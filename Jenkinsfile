@Library('practice-shared-lib') _

def config = [:]
config.appServiceId = '9999'
config.appServiceName = 'mylab'
config.softwareModuleName = 'mymodule'
config.sonarProjectKey = 'practice-app'
config.buildCommand = "mvn clean install -U"
config.integrationTestCommands = [
    develop: ["echo running e2e tests"]
]

PracticePipeline(config)
