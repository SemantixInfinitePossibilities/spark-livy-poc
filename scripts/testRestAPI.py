import json, pprint, requests, textwrap

host = 'http://localhost:8998'
data = {'kind': 'spark'}
headers = {'Content-Type': 'application/json'}

print('Creating a session ...\n')
r = requests.post(host + '/sessions', data=json.dumps(data), headers=headers)
print('Should show a starting state.\n')
r.json()

print('Getting Information of created session ...\n')
session_url = host + r.headers['location']
r = requests.get(session_url, headers=headers)
print('Should show a idle state.\n')
r.json()

print('Now we can execute Scala by passing in a simple JSON command:\n')
statements_url = session_url + '/statements'
data = {'code': '1 + 1'}
r = requests.post(statements_url, data=json.dumps(data), headers=headers)
print('Should show a runing or waiting state.\n')
r.json()


print('If a statement takes longer than a few milliseconds to execute, Livy returns early and provides a statement URL that can be polled until it is complete:\n')
statement_url = host + r.headers['location']
r = requests.get(statement_url, headers=headers)
print('Should show the evaluation result.\n')
pprint.pprint(r.json())

print('Finally, close the session:\n')
requests.delete(session_url, headers=headers)

