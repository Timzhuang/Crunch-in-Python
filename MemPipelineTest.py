from py4j.java_gateway import JavaGateway
import sys

gateway = JavaGateway()


inputPath = sys.argv[0]


person_data = gateway.jvm.readTextFromFileWrapper()


print(person_data)
