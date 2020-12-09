from py4j.java_gateway import JavaGateway
from py4j.java_gateway import java_import

gateway = JavaGateway()

gateway.entry_point.makePair(3, "dog")
pair = gateway.entry_point.getPair()
print(pair)
print(type(gateway.entry_point.getFirst()))
print(type(gateway.entry_point.getSecond()))
'''
  [3,dog]
  <class 'int'>
  <class 'str'>
'''

gateway.entry_point.makePair("cat", 2.0)
pair = gateway.entry_point.getPair()
print(pair)
print(type(gateway.entry_point.getFirst()))
print(type(gateway.entry_point.getSecond()))
'''
  [cat,2.0]
  <class 'str'>
  <class 'float'>
'''

gateway.entry_point.makeTuple("foo", 1723, 2.3, False, 1.2)
tuplen = gateway.entry_point.getTuple()
print(tuplen)
  # [foo, 1723, 2.3, false, 1.2]
vals = gateway.entry_point.getTupleVals()
for val in vals:
  print(type(val))
'''
<class 'str'>
<class 'int'>
<class 'float'>
<class 'bool'>
<class 'float'>
'''

gateway.entry_point.makeTuple("foo", 1723, 2.3, False, 1.2, "foobar")
tuplen = gateway.entry_point.getTuple()
print(tuplen)
  # [foo, 1723, 2.3, false, 1.2, foobar]
vals = gateway.entry_point.getTupleVals()
for val in vals:
  print(type(val))
'''
<class 'str'>
<class 'int'>
<class 'float'>
<class 'bool'>
<class 'float'>
<class 'str'>
'''

