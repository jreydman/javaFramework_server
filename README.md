# javaFramework_server
java, mini framework for servers!

# Basic fork:
  * Config
  * Library
  * Hook
 --------------------------------------------------------
 **--Library.Database--**
 Construct(hostname, port, db, username, password)
 Connect() // make new connection
 Disconnect(Connection)
 CloseStatement(Statement)
 baseQuery(query)
 procQuery(procName, paramPattern)
 
 **--Library.Reader--**
 Construct(display)
 read()
 use()
 --------------------------------------------------------
 
 # Repository interface
 privates: exec(query)
 public:
  * find(table, pattern)
  * one(table,pattern/object)
  * pull(table,object)
