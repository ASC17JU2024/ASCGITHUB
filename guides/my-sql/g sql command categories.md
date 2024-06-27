Categories of SQL statements:

1. **DDL (Data Definition Language)**:
   - **Purpose**: Defines and manages database structures.
   - **Examples**:
     - `CREATE`: Creates a new table, view, index, or database.
     - `ALTER`: Modifies an existing database object, such as adding or dropping columns in a table.
     - `DROP`: Deletes a database object, such as a table or a view.
     - `TRUNCATE`: Removes all records from a table, but does not log individual row deletions.
     - `RENAME`: Renames a database object.

2. **DML (Data Manipulation Language)**:
   - **Purpose**: Manages data within schema objects.
   - **Examples**:
     - `SELECT`: Retrieves data from the database.
     - `INSERT`: Adds new data to a table.
     - `UPDATE`: Modifies existing data in a table.
     - `DELETE`: Removes data from a table.
     - `MERGE`: Inserts or updates data based on certain conditions.

3. **DQL (Data Query Language)**:
   - **Purpose**: Subcategory of DML focused on querying data.
   - **Examples**:
     - `SELECT`: Fetches data from the database based on specified criteria.

4. **TCL (Transaction Control Language)**:
   - **Purpose**: Manages transactions in the database.
   - **Examples**:
     - `COMMIT`: Saves the transaction’s changes to the database.
     - `ROLLBACK`: Undoes changes made in the current transaction.
     - `SAVEPOINT`: Sets a savepoint within a transaction to which you can later roll back.
     - `SET TRANSACTION`: Sets the characteristics of the current transaction.

5. **DCL (Data Control Language)**:
   - **Purpose**: Controls access to data within the database.
   - **Examples**:
     - `GRANT`: Gives users access privileges to the database.
     - `REVOKE`: Removes access privileges given to users.

6. **DML (Data Manipulation Language)**:
   - **Purpose**: Manipulates data within schema objects.
   - **Examples**:
     - `SELECT`: Retrieves data from the database.
     - `INSERT`: Adds new data to a table.
     - `UPDATE`: Modifies existing data in a table.
     - `DELETE`: Removes data from a table.
     - `MERGE`: Inserts or updates data based on certain conditions.

These categories help classify the operations you can perform in SQL, providing a clearer understanding and organization of database interactions.