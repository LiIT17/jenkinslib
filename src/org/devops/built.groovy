package org.devops

def getType(builttype) {
    def toolsType = ["maven":"mvn", "ant":"ant", "gradle":"gradle", "npm":"npm"]
    println("当前构建类型为 ${builttype}")
    def tool = toolsType[builttype]  // 不需要${}语法
    sh "${tool} ${version}"  // 需要双引号来引用变量
}
