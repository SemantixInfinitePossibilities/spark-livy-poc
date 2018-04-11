import json, pprint, requests, textwrap

host = 'http://localhost:8998'
data = {'kind': 'spark'}
headers = {'Content-Type': 'application/json'}
print('Creating a session:\n')
r = requests.post(host + '/sessions', data=json.dumps(data), headers=headers)
r.json()

session_url = host + r.headers['location']
statements_url = session_url + '/statements'

data = {
  'code': textwrap.dedent("""
    val NUM_SAMPLES = 100000;
    val count = sc.parallelize(1 to NUM_SAMPLES).map { i =>
      val x = Math.random();
      val y = Math.random();
      if (x*x + y*y < 1) 1 else 0
    }.reduce(_ + _);
    println(\"Pi is roughly \" + 4.0 * count / NUM_SAMPLES)
    """)
}

print('Submiting a estimation PI job ...')
r = requests.post(statements_url, data=json.dumps(data), headers=headers)
pprint.pprint(r.json())

print('Should show the estimated PI:\n')
statement_url = host + r.headers['location']
r = requests.get(statement_url, headers=headers)
pprint.pprint(r.json())

requests.delete(session_url, headers=headers)

