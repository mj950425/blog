rootProject.name = "blog"

include("ui")
include("domain")
include("infra-persistence")
include("infra-client")
include("common")

rootProject.children.forEach {
    it.apply {
        projectDir = if (this.name.startsWith("infra")) {
            file("app/infra/$name")
        } else {
            file("app/$name")
        }
        buildFileName = "build.gradle.kts"
        require(projectDir.isDirectory) { "Project '${it.path} must have a $projectDir directory" }
        require(buildFile.isFile) { "Project '${it.path} must have a $buildFile build script" }
    }
}