project_root := justfile_directory()

default:
    @just --list

run:
    {{project_root}}/gradlew run

run-dist:
    app/build/install/app/bin/app
