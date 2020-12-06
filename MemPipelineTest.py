from py4j.java_gateway import JavaGateway
import sys

gateway = JavaGateway()

x = gateway.getInstance()


inputPath = sys.argv[0]


person_data = x.readTextFile(inputPath)


print(person_data)
