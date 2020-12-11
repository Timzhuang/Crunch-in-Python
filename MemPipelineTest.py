from py4j.java_gateway import JavaGateway
import sys

gateway = JavaGateway()


def shout(stringy):
    return stringy.split()


inputPath = sys.argv[0]

x = gateway.getInstance()

person_data = gateway.readTextFromFileWrapper(x)

words = gateway.parallelDoWrapper(person_data)

print(words.count())
