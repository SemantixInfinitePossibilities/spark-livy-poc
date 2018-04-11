import com.cloudera.livy.{ JobContext, LivyClient, LivyClientBuilder }
//import com.cloudera.livy.client.http.HttpClient
import com.ning.http.client.AsyncHttpClient
import java.net.URI
import scala.util.{ Try, Success }
//import com.cloudera.livy.scalaapi._

object LivyDemoApp {
  val livyServerUrl = "http://localhost:8998/"

  def main(args: Array[String]) = {
    livyJobCreation()
  }

  def livyClientRequest() = {
    val client = HttpClient

  }

  def livyJobCreation() {
    val client = new LivyClientBuilder().setURI(new URI(livyServerUrl)).build();
    //println("Uploading %s to the Spark context...\n", piJar)
    //client.uploadJar(new File(piJar)).get
    val samples = 100
    println("Running PiJob with %d samples...\n", samples)
    Try(client.submit(new PIJob(samples))) match {
      case Success(pi) => println("Pi is roughly: " + pi); client.stop(true)
      case _ => client.stop(true)
    }
  }
}
