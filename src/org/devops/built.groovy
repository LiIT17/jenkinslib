package org.devops

def get-type(builttype){
    def Toolstype = ["maven":"mvn","ant":"ant","gradle":"gradle","nodejs":"nmp" ]
    println("当前构建类型为 ${builttype}")
    tool = Toolstype[${builttype}]
    sh '$tool $version'
 }
