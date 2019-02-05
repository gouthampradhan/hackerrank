package scala

import scala.io.Source

/**
  * Created by gouthamvidyapradhan on 03/02/2019
  */
object Mangoes {
  case class Friend(apetite: Long, hFactor: Long, nFriends: Int) {
    lazy val total = apetite + (nFriends * hFactor)
  }

  def main(args: Array[String]) {
    val lines = Source.stdin.getLines().take(3)
    val line1 = lines.next()
    val line2 = lines.next()
    val line3 = lines.next()
    val N = line1.split(" ")(0).toInt
    val M = line1.split(" ")(1).toLong
    val apetite = line2.split(" ").map(_.toInt)
    val hFactor = line3.split(" ").map(_.toInt)
    var h = N
    var l = 1
    var ans = 0
    while (l <= h) {
      val m = l + (h - l) / 2
      val friends = apetite.indices.map(i => Friend(apetite(i), hFactor(i), m - 1))
      val sorted = friends.sortWith(_.total < _.total)
      val res = sorted.take(m).map(_.total).sum
      if (res <= M) {
        ans = Math.max(ans, m)
        l = m + 1
      } else {
        h = m - 1
      }
    }
    println(ans)
  }
}
