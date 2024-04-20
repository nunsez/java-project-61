project_root := justfile_directory()
gradlew := join(project_root, "app", "gradlew") + " --project-dir " + join(project_root, "app")
shell-nix := join(project_root, "shell.nix")

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
    {{join(project_root, "app", "build", "install", "app", "bin", "app")}}
