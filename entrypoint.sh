#!/bin/bash
set -e

# Ensure chromedriver has execution permissions
chmod +x /usr/local/bin/chromedriver

# Run the tests
mvn clean test
