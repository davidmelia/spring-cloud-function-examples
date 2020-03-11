import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description('should send an fx rate')

    label('triggerJsonFxRateBatchEvent')
    input {
        triggeredBy('triggerJsonFxRateBatchEvent()')
    }
    outputMessage {
        sentTo('json-fx-rate-batch-events')
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

