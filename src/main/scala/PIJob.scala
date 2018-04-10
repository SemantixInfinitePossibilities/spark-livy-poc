import com.cloudera.livy.{Job, JobContext}
//import collection.JavaConverters._
import collection.JavaConversions._

class PIJob(samples: Int) extends Job[Double, Function[Int, Int], Function2[Int, Int, Int]] {

    def call(ctx: JobContext) = {
      val values = (1 to samples).toList
      //4.0d * ctx.sc().parallelize(values).map(this).reduce(this) / samples
    }

    def call(v1: Int) = {
      val (x, y)  = (Math.random(), Math.random())
      if(x*x + y*y < 1)  1 else 0
    }

    def call(v1: Int, v2: Int) = v1 + v2

}
