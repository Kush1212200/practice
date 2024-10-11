package com.hexaware.jdbc;
import static org.mockito.Mockito.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class jdbcdemo {
private Test2 test2;


	@Test
	public void testInsertEmployee() throws SQLException {
		Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);  // Simulating 1 row affected

        // Using a helper method to invoke the actual logic with the mocked objects
        Test2 test2= new Test2();
        test2.insertEmployee(mockConnection);

        // Verifying the PreparedStatement interactions
        verify(mockPreparedStatement).setInt(1, 123);
        verify(mockPreparedStatement).setString(2, "Ram");
        verify(mockPreparedStatement).setString(3, "Kumar");
        verify(mockPreparedStatement).setString(4, "rk785667@outlook.com");
        verify(mockPreparedStatement).setDate(5, java.sql.Date.valueOf("2024-10-03"));
        verify(mockPreparedStatement).executeUpdate();
        verify(mockConnection).close();
    }
	}



