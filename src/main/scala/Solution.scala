import circe.EnrichedEvent
import io.circe.generic.auto._
import io.circe.parser._
object Solution extends App {

  val jsonStr =
    """
      {
        "version": "1.1",
        "bidderId": 1481191517,
        "timestamp": 1489391574703,
        "deviceId": "deviceIdLinh",
        "type": 4,
        "ipAddr": "79.158.124.168",
        "userAgent": "Mozilla/5.0 (iPad; CPU OS 10_2 like Mac OS X) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0 Mobile/14C92 Safari/602.1",
        "freqManaged": true,
        "frequencyManagementInfo": {
          "ioImpressionManaged": true,
          "campaignImpressionManaged": false,
          "ioClickManaged": false
        },
        "bidInfo": {
          "bidId": "a52b9dfbbbf1dde0a4c20580c10c96eed3bf99ca81f93197a019",
          "hourEpoch": 413719,
          "ioId": 204928,
          "parentId": 204928,
          "campaignId": 125394,
          "osId": 1,
          "exchangeId": 32,
          "platformId": 2,
          "publisher": "elConfidencial",
          "brand": "Apple",
          "model": "iPad",
          "skyhook": 0,
          "bidAmount": 210,
          "bidFloor": 0,
          "pubId": "9109",
          "appId": "117606",
          "bundleId": "",
          "isInterstitial": "FALSE",
          "deviceType": "TABLET",
          "osVersion": "",
          "deviceCarrier": "",
          "connectionType": "0",
          "clickProbability": -1,
          "audienceListCost": 0,
          "pocketmathFee": 12500
        }
      }
    """.stripMargin
  val json = parse(jsonStr)
  json match {
    case Left(failure) =>
      println(s"Invalid JSON string:(, ${failure.getCause.getMessage}")
    case Right(j) =>
      j.as[EnrichedEvent] match {
        case Left(failure) =>
          println(s"Invalid json, ${failure.getMessage()}")
        case Right(event) => println(event.bidInfo.bidId)
      }
  }

}
