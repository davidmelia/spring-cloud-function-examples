import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description('should send an fx rate')

    label('triggerAvroFxRateBatchEventArrayHack')
    input {
        triggeredBy('triggerAvroFxRateBatchEventArrayHack()')
    }
    outputMessage {
        sentTo('avro-fx-rate-batch-events')
        body(
           [
                [
                    
	                from: 'GBP',
	                to: 'USD',
	                rate: '1.23'
                    
                ]
            ]         
        )
    }
}

