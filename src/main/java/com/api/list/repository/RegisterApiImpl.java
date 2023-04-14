package com.api.list.repository;

import java.security.Timestamp;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Instant;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import com.api.list.entity.RegisterApi;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

@ApplicationScoped
public class RegisterApiImpl implements RegisterApiRepo {

	@Inject
	@Named("dbLMDM")
	private DataSource ds;
	

	@Override
	public String saveRegisterApi(RegisterApi registerApi) throws Exception {
		CallableStatement cStmt = null;
		Connection conn = null;
			String message=null;
			try {
				Gson gson= new Gson();
				String jsonData = gson.toJson(registerApi);
				conn = ds.getConnection();		
				cStmt = conn.prepareCall("{Call  SAVE_REGISTER_API(?,?)}");
				Clob stmtClob = conn.createClob();
				stmtClob.setString(1, jsonData);
				cStmt.setClob("in_emp_json", stmtClob);
				cStmt.registerOutParameter("OUT_ERR_MSG", java.sql.Types.VARCHAR);
				cStmt.execute();
				cStmt.registerOutParameter("OUT_ERR_MSG", java.sql.Types.VARCHAR);
				message = cStmt.getString("OUT_ERR_MSG");			
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("");
			} finally {
				try {
					if (cStmt != null) {
						cStmt.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}		
			return message;
		}
		
	}



	
	
	
