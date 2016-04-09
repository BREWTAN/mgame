package mauthlogin

import scala.concurrent.Promise
import scala.concurrent.Future
import scala.collection.mutable.MutableList
import scala.concurrent.ExecutionContext.Implicits.global

object TestM {

  def testm(i: Int, p: Promise[String]) {

    new Thread(new Runnable() {
      def run() {
        Thread.sleep(100 * i);
        println(System.currentTimeMillis() + ":okok::" + i);
        p.success("OKOK::" + i)
      }
    }).start()
    p.future
  }

  def main(args: Array[String]): Unit = {

    val v = Double.box(1.0)
    println("v==is null:" + (Double.box(v) != null))

    val l = List(0, 1, 2, 3, 4, 5)

    val result = MutableList[String]();
    val res = l.map { x =>
      val p = Promise[String]
      testm(x, p);
      p.future
    }

    Future.sequence(res).onComplete { x =>
      x.foreach { p =>
        p.foreach { pp =>  
          println("pp = " + pp)
          
        }
        println("p = " + p)
      }

      println(System.currentTimeMillis() + ":res.seq.onComplete:" + x)
    }

    Thread.sleep(10 * 1000)

    //    res.foldLeft(Future { " " }) { (r, f) =>
    //      println("r==" + r + ",f=" + f);
    //      result.+=(r.value.get.get)
    //      r;
    //    }.onComplete { x => 
    //      println(System.currentTimeMillis()+":all completed!!")
    //    }

    //    foldLeft(""){ (r,f) =>
    //      println("r==" + r+",f="+f);
    //      result.+=(r)
    //      r
    //    }

  }
}