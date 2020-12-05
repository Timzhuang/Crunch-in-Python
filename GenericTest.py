from py4j.java_gateway import JavaGateway
from py4j.java_gateway import java_import

gateway = JavaGateway()
java_import(gateway.jvm,'java.util.*')

jList = gateway.jvm.ArrayList()

print(jList.isEmpty()) # True

jList.add(3)
print(jList.isEmpty()) # False
print(jList.get(0)) # 3
print(jList.get(0) + 2) # 5

jList.add("cat")
print(jList.get(1)) # cat
print(jList.get(1)[1:]) # at

print(type(jList.get(0))) # <class 'int'>
print(type(jList.get(1))) # <class 'str'>

java_import(gateway.jvm, 'javafx.util.*')
# jPair = gateway.jvm.Pair() # error because no Pair() c'tor

jPair = gateway.jvm.Pair(1, 2)
print(jPair) # 1=2
jPair = gateway.jvm.Pair(2, 3)
print(jPair) # 2=3
jPair = gateway.jvm.Pair(2, "dog")
print(jPair) # 2=dog

java_import(gateway.jvm, 'org.apache.crunch.PCollection')
# pCollection = gateway.jvm.PCollection()
# py4j.Py4JException: Constructor org.apache.crunch.PCollection([]) does not exist