import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description('should send an fx rate')

    label('triggerFxRateEvent')
    input {
        triggeredBy('triggerFxRateEvent()')
    }
    outputMessage {
        sentTo('avro-fx-rate-events')
        body([
                from: "GBP",
                to: "USD",
                rate: "1.23"
        ])
    }
}