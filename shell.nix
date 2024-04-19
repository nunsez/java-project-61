let
  nixpkgs = builtins.fetchGit {
    url = "https://github.com/NixOS/nixpkgs.git";
    ref = "refs/heads/master";
    rev = "f1e8e4837d258a15a5564fdaadc436bee2c38f87";
  };
  pkgs = import nixpkgs {};
in
pkgs.mkShell {
  name = "kotlin-project-1";

  packages = [
    pkgs.gradle_8
    pkgs.jdk21
    # pgks.temurin-bin-21
  ];
}
