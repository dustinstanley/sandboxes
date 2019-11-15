#!/bin/bash

mkdir ~/.aws | true

#
# .aws/config
#
echo "[default]" > ~/.aws/config
echo "output = json" >> ~/.aws/config
echo "region = us-west-2" >> ~/.aws/config

#
# .aws/credentials
#
echo "[default] " > ~/.aws/credentials
echo "aws_access_key_id = $AWS_ACCESS_KEY_ID" >> ~/.aws/credentials
echo "aws_secret_access_key = $AWS_SECRET_ACCESS_KEY" >> ~/.aws/credentials
