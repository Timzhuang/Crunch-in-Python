from py4j.java_gateway import JavaGateway

gateway = JavaGateway()

# function calls: gateway.entry_point.FUNCTION_CALL()

x = gateway.entry_point.return3()
print(x)