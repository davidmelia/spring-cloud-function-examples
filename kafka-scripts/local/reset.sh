kafka-topics --zookeeper localhost:32181 --delete --topic avro-fx-rate-events
kafka-topics --zookeeper localhost:32181 --delete --topic json-fx-rate-events
kafka-topics --create --zookeeper localhost:32181 --replication-factor 1 --partitions 3 --topic avro-fx-rate-events
kafka-topics --create --zookeeper localhost:32181 --replication-factor 1 --partitions 3 --topic json-fx-rate-events