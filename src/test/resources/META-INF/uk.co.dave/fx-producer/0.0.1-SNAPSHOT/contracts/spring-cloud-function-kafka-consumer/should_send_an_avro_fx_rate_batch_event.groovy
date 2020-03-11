import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description('should send an fx rate')

    label('triggerAvroFxRateBatchEvent')
    input {
        triggeredBy('triggerAvroFxRateBatchEvent()')
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

