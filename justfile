project_root := justfile_directory()
gradlew := join(justfile_directory(), "gradlew")
shell-nix := join(justfile_directory(), "shell.nix")

alias s := shell
alias l := lint
alias fmt := format

default:
    @just --list

shell:
    nix-shell {{shell-nix}}

run:
    {{gradlew}} run

lint:
    {{gradlew}} detektMain

format:
    {{gradlew}} ktlintFormat

run-dist:
    app/build/install/app/bin/app
