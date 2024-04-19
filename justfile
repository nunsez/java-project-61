project_root := justfile_directory()
gradlew := join(justfile_directory(), "gradlew")

alias l := lint
alias fmt := format

default:
    @just --list

run:
    {{gradlew}} run

lint:
    {{gradlew}} detektMain

format:
    {{gradlew}} ktlintFormat

run-dist:
    app/build/install/app/bin/app
