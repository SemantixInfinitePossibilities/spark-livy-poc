import com.cloudera.livy.{ JobContext, LivyClient, LivyClientBuilder }
import java.net.URI
import scala.util.{ Try, Success }

object LivyDemoApp {
  val livyUrl = "http://localhost:8998/"

  def main(args: Array[String]) = {
    livyJobCreation()
  }

  def livyClientRequest() = {

  }

  def livyJobCreation() {
    val client = new LivyClientBuilder().setURI(new URI(livyUrl)).build();
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
