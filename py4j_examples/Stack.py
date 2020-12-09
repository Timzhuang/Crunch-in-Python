from py4j.java_gateway import JavaGateway

gateway = JavaGateway()
stack = gateway.entry_point.getStack()
stack.push("First Item")
stack.push("Second Item")
stack.pop()
stack.pop()
