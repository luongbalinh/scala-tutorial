package circe
case class EnrichedEvent(
    version: String,
    bidderId: Long,
    timestamp: Long,
    `type`: Int,
    deviceId: String,
    ipAddr: String,
    userAgent: Option[String],
    freqManaged: Option[Boolean],
    bidInfo: EnrichedBidInfo,
    frequencyManagementInfo: Option[FrequencyManagementInfo]
)
