#!/usr/bin/env groovy

/**
 * 获取指定构建工具的版本号
 * 
 * @param toolName 构建工具名称，支持 'maven', 'ant', 'gradle', 'npm' 等
 * @return 返回对应工具的版本号
 */
def getToolVersion(String toolName) {
    echo "正在获取 ${toolName} 的版本信息..."
    
    def version = ""
    
    switch(toolName.toLowerCase()) {
        case 'maven':
            version = sh(script: 'mvn --version | grep "Apache Maven" | cut -d " " -f 3', returnStdout: true).trim()
            break
        case 'ant':
            version = sh(script: 'ant -version | grep "Apache Ant" | cut -d " " -f 4', returnStdout: true).trim()
            break
        case 'gradle':
            version = sh(script: 'gradle --version | grep "Gradle" | head -n 1 | cut -d " " -f 2', returnStdout: true).trim()
            break
        case 'npm':
            version = sh(script: 'npm --version', returnStdout: true).trim()
            break
        default:
            echo "不支持的构建工具: ${toolName}"
            version = "未知"
    }
    
    echo "检测到 ${toolName} 版本: ${version}"
    return version
}

/**
 * 为了兼容Pipeline中的直接调用，提供call方法
 */
def call(String toolName) {
    return getToolVersion(toolName)
}
