#!/bin/bash

set -o errexit -o nounset

if [ "$TRAVIS_BRANCH" != "master" ]
then
  echo "This commit was made against the $TRAVIS_BRANCH and not the master! No deploy!"
  exit 0
fi

rev=$(git rev-parse --short HEAD)

# create folder for doc output
mkdir doc_output


# generate static docs
jekyll build --source docs --destination doc_output

# run the load tests
mvn jmeter:jmeter

# create load test results image
mvn jmeter-graph:create-graph -Dloadtest.output="doc_output/assets/images/loadtest.png"

cd doc_output

git init
git config user.name "Christian Günther"
git config user.email "chr.gue@gmail.com"

git remote add upstream "https://$GITHUB_TOKEN@github.com/chrgue/try-nashorn.git"
git fetch upstream
git reset upstream/gh-pages


git add -A .
git commit -m "rebuild pages at ${rev}"
git push -q upstream HEAD:gh-pages