#!/bin/bash

export JDBC_URL="jdbc:mysql://nonproddb.cynprxzxw8wr.us-west-2.rds.amazonaws.com:3306/revaturev2_s3?autoReconnect=true&zeroDateTimeBehavior=convertToNull"
export JDBC_USERNAME="rev_devind"
export JDBC_PASSWORD="revdevindia"

export EMAIL_REGARDS_URL="https://www.revature.com"
export SINK_MAIL="harini@revature.com,kanchana@revature.com"

export CORE_APP_EMAIL_TRIGGER_URL="http://localhost/core/resources/scheduler/triggerEmailJob?emailJobId="