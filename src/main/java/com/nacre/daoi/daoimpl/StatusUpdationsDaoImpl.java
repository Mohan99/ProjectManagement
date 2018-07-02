/**
 * 
 */
package com.nacre.daoi.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.nacre.constants.SQLQueryConstants;
import com.nacre.daoi.StatusUpdationsDaoI;
import com.nacre.dto.DeveloperTaskDto;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.uitl.PooledConnection;
import org.apache.log4j.Logger;

import com.nacre.constants.IntegerConstants;
import com.nacre.constants.SQLQueryConstants;
import com.nacre.daoi.StatusUpdationsDaoI;
import com.nacre.dto.DeveloperTaskDto;
import com.nacre.dto.ModuleStatusDto;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.ProjectManagerProjectDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.ProjectStatusDto;
import com.nacre.dto.TaskStatusDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.uitl.PooledConnection;

/**
 * @author Vijay Kumar Reddy K
 *
 *
 */
public class StatusUpdationsDaoImpl implements StatusUpdationsDaoI {

public static final Logger logger = 	Logger.getLogger(StatusUpdationsDaoImpl.class);
/**
 * @author Pujitha 
 * @param dto
 * @param i
 * @return int
 */
@Override
public int insertTask_Status( TaskStatusDto dto,int i) throws SQLException 
{
	
	
	Connection con=null;
	try {
		con=PooledConnection.getConnection();
	
	PreparedStatement pstmt=null;
	pstmt=con.prepareStatement(SQLQueryConstants.INSERT);
	pstmt.setString(1, dto.getStatusInfo());
	pstmt.setString(2, dto.getDifficulties());
	
	
	/*String dt=dto.getUpdationDate();
	 Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dt);  
	 java.sql.Date sDate=new java.sql.Date(date1.getTime());*/
	pstmt.setDate(3,  new java.sql.Date(dto.getUpdationDate().getTime()));
	
	// StatusDto status=new StatusDto();
   // status.getStatusId();
	 pstmt.setInt(4,IntegerConstants.seenStatusId);
	 
	 pstmt.setInt(5, dto.getDeveloperTaskId().getDeveloperTaskId());
	 
	int i2= pstmt.executeUpdate();
	 con.commit();
	System.out.println("Db update is "+i+" "+dto.getDeveloperTaskId().getDeveloperTaskId());
	 PreparedStatement pstmt2=null;
	 pstmt2=con.prepareStatement(SQLQueryConstants.updateTaskPercentage);
	 pstmt2.setInt(1, i);
	 pstmt2.setInt(2,  dto.getDeveloperTaskId().getDeveloperTaskId());
	 int i3=pstmt2.executeUpdate();
	 con.commit();
	 if(i3>0)
	 {
		 System.out.println("TaskStausUpdated");
	 }
	 else
	 {
		 System.out.println("  TaskStaus is not updated ");
	 }
	 con.close();
	 return i2;
	
	} catch (NoConnectionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	return 0;
	
	} // TODO Auto-generated method stub

	}

@Override
public int insertModule_Status(Connection con, ModuleStatusDto dto) throws SQLException
{
	// TODO Auto-generated method stub
	PreparedStatement pstmt=null;
	pstmt=con.prepareStatement(SQLQueryConstants.INSERTMODULE_STATUS);
	
	pstmt.setString(1, dto.getStatusInfo());
	pstmt.setString(2, dto.getDificulties());
	pstmt.setDate(3, new java.sql.Date(dto.getUpdationDate().getTime()));
	
	pstmt.setInt(4, IntegerConstants.seenStatusId);
	
	pstmt.setInt(5, dto.getModuleStatusId());
	
	int i= pstmt.executeUpdate();
	 con.commit();
	
	
	return i;
}

@Override
public int insertProject_Status(Connection con, ProjectStatusDto dto) throws SQLException 
{
	// TODO Auto-generated method stub
	PreparedStatement pstmt=null;
	pstmt=con.prepareStatement(SQLQueryConstants.INSERTPROJECT_STATUS);
	
	pstmt.setString(1, dto.getStatusInfo());
	pstmt.setString(2, dto.getDifficulties());
	pstmt.setDate(3, new java.sql.Date(dto.getUpdationDate().getTime()));
	
	pstmt.setInt(4, dto.getProjectManagerProjectId().getProjectManagetProjectId());
	
	pstmt.setInt(5, IntegerConstants.seenStatusId);
	
	
	ProjectManagerProjectDto p=new ProjectManagerProjectDto();
	int i= pstmt.executeUpdate();
	 con.commit();
	
	
	return i;
}

@Override
public int Percentage_Completion_Task(Connection con, ModuleTaskDto dto) throws SQLException 
{
	// TODO Auto-generated method stub
	PreparedStatement pstmt=null;
	pstmt=con.prepareStatement(SQLQueryConstants.PercentageTaskQuery);
	pstmt.setFloat(1, dto.getTaskCompletionPercent());
	pstmt.setInt(2, dto.getModuleTaskId());
	
	int i=pstmt.executeUpdate();
	con.commit();
	
	
	return i;
}
/**
 * @author Ram Babu
 * @param dto
 * @param a
 * @return Integer
 */
@Override
public int Percentage_Completion_Module(ModuleStatusDto dto, int a) throws SQLException
{
	// TODO Auto-generated method stub
	Connection con=null;
	try {
		con = PooledConnection.getConnection();
	
	//con.setAutoCommit(false);
	PreparedStatement pstmt=null;
	pstmt=con.prepareStatement(SQLQueryConstants.InsertModuleStatus);
	pstmt.setString(1, dto.getStatusInfo());
	pstmt.setString(2, dto.getDificulties());
	//ProjectModuleDto p=dto.getProjectModuleId();
	int i1=dto.getProjectModuleId().getProjectModuleId();
	
	System.out.println("valus of i1:"+i1);
	
	pstmt.setInt(3, i1);
	pstmt.setInt(4, 13);
	java.sql.Date date=new java.sql.Date(dto.getUpdationDate().getTime());
	pstmt.setDate(5, date);
	int i=pstmt.executeUpdate();
	System.out.println("return it:"+i);
	con.commit();
	
	PreparedStatement pstmt2=null;
	pstmt2=con.prepareStatement(SQLQueryConstants.PercentageModuleQuery);
	pstmt2.setInt(1, a);
	pstmt2.setInt(2, i1);
	System.out.println(a+"value of a and i1 "+i1);
	int p1=pstmt2.executeUpdate();
	con.commit();
	if(p1>0)
	{
		System.out.println("ModulePercenteage updated");
	}
	else
	{
		System.out.println("ModulePercenteage is not updated");
	}
		con.close();
	
	return i;
	} catch (NoConnectionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	return 0;
	}
	}

@Override

/**
 * @author Biranchi
 * @param dto
 * @param b
 * @return Integer
 * 
 */
public int Percentage_Completion_Project( ProjectStatusDto dto, int b,Integer userID) throws SQLException 
{
	// TODO Auto-generated method stub
	Connection con=null;
	try {
		con=PooledConnection.getConnection();
	PreparedStatement pstmt=null;
	pstmt=con.prepareStatement(SQLQueryConstants.INSERTPROJECT_STATUS);
	pstmt.setString(1, dto.getStatusInfo());
	pstmt.setString(2, dto.getDifficulties());
	
	java.sql.Date date=new java.sql.Date(dto.getUpdationDate().getTime());
	pstmt.setDate(3, date);
	
	ProjectManagerProjectDto pm=dto.getProjectManagerProjectId();
	int pm2=pm.getProjectManagetProjectId();
	pstmt.setInt(4, pm2);

	pstmt.setInt(5, userID);
	pstmt.setInt(6, IntegerConstants.NOT_SEEN_STATUS);
	
	int i=pstmt.executeUpdate();
   con.commit();
  
   int pi=0;
	PreparedStatement pstmt3=con.prepareStatement(SQLQueryConstants.getProjectId);
	pstmt3.setInt(1, pm2);
	ResultSet rs=pstmt3.executeQuery();
	while(rs.next())
	{
		pi=rs.getInt(1);
	}
	
	PreparedStatement pstmt4=con.prepareStatement(SQLQueryConstants.updateProjectPercentage);
	pstmt4.setInt(1, b);
	pstmt4.setInt(2, pi);
	System.out.println("finding for updates:"+b+" "+pi);
	 int p1=pstmt4.executeUpdate();
		if(p1>0)
		{
			System.out.println("ProjectStatusPercenteage updated");
		}
		else
		{
			System.out.println("ProjectStatusPercenteage is not updated");
		}	
	con.commit();
	con.close();
	return i;

	} catch (NoConnectionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	return 0;
	}
	
	}

/**
 * @author Ram Babu
 * @param i
 * @return List
 */
@Override
public List<ProjectModuleDto> getModules(int i) 
{
	// TODO Auto-generated method stub
	Connection con=null;
	try {
		con = PooledConnection.getConnection();
	
	List<ProjectModuleDto> al=new ArrayList<>();
	try {
		PreparedStatement pstmt=con.prepareStatement(SQLQueryConstants.getModule);
		
		pstmt.setInt(1, i );
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			ProjectModuleDto p=new ProjectModuleDto();
			p.setProjectModuleId(rs.getInt(1));
			p.setModuleTitle(rs.getString(2));
			al.add(p);
			System.out.println(al);
		}
		return al;

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	} catch (NoConnectionException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	return Collections.emptyList();

}

/**
 * @author Ram Babu
 * @param i
 * @return ProjectModuleDto
 */
@Override
public ProjectModuleDto getModulePercentage(int i) 
{
	ProjectModuleDto p=new ProjectModuleDto();
	int y=0;
	int c=0;
	float f;
  try {
	Connection con=PooledConnection.getConnection();
	PreparedStatement pstmt=con.prepareStatement(SQLQueryConstants.getModulePercentage);
	pstmt.setInt(1, i);
	ResultSet rs=pstmt.executeQuery();
	while(rs.next())
	{
		y=y+rs.getInt(1);
		c++;
	}
	if(c!=0){
	f=y/c;
	p.setModuleCompletionPercent(f);
	}else{
		p.setModuleCompletionPercent(0.0f);
			
	}
	
	con.close();
} catch (NoConnectionException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  
	return p;
}

@Override
public ProjectDto getProjectPercentage(int i) 
{
	ProjectDto pd=new ProjectDto();
	int y=0;
	int c=0;
	double f;
	Connection con=null;
	
	try {
		
		con = PooledConnection.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLQueryConstants.getProjectPercentage);
		pstmt.setInt(1, i);
		ResultSet rs=pstmt.executeQuery();

		while(rs.next())
		{
			y=y+rs.getInt(1);
			c++;
		}
		if(c!=0){
		f=y/c;
		pd.setProjectCompletionPercentage(f);
		
		}else{
			
			pd.setProjectCompletionPercentage(0.0);
			
		}
		con.close();
	} catch (NoConnectionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return pd;
}

@Override
public List<ProjectManagerProjectDto> getProjects(int i) 
{
	Connection con=null;
	try {
		con = PooledConnection.getConnection();
	} catch (NoConnectionException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	List<ProjectManagerProjectDto> al=new ArrayList<>();
	try {
		PreparedStatement pstmt=con.prepareStatement(SQLQueryConstants.getProjectManagetProjectId);
		pstmt.setInt(1, i );
		logger.info(pstmt.toString());
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			ProjectManagerProjectDto p=new ProjectManagerProjectDto();
			p.setProjectManagerProjectId(rs.getInt(1));
			al.add(p);
			System.out.println(al);
		}
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	;
	return al;
}

/**
 * @author Pujitha
 * @param cid1
 * @return ModuleTaskDto
 */
@Override
public ModuleTaskDto getTaskCompletionPercentage(int cid1) 
{
	ModuleTaskDto mtd=new ModuleTaskDto();
	Connection con=null;
	try {
		con=PooledConnection.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SQLQueryConstants.getTaskCompletionPercentage);
		pstmt.setInt(1, cid1);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			int i=rs.getInt(1);
			
			float f=i;
			mtd.setTaskCompletionPercent(f);
			
		}

		con.close();
	} catch (NoConnectionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return mtd;
}

/**
 * @author Pujitha
 * @param i
 * @return List
 */
@Override
public List<DeveloperTaskDto> getAllTaskId(int i)
{
	List<DeveloperTaskDto> l=new ArrayList<>();
	//DeveloperTaskDto dtd=null;
	Connection con=null;
	try {
		con=PooledConnection.getConnection();
		logger.info(con);
	} catch (NoConnectionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
			logger.info(con);
		PreparedStatement pstmt=con.prepareStatement(SQLQueryConstants.getAllTaskId);
		pstmt.setInt(1, i);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			DeveloperTaskDto dtd=new DeveloperTaskDto();
			int i1=rs.getInt(1);
			dtd.setDeveloperTaskId(i1);
			l.add(dtd);
			System.out.println("daoi  "+l);
		}
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
	return l;
}


/*public void insertStatus(){
	System.out.println("first");
		try {
			Connection con=PooledConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(SQLQueryConstants.INSERT_TASK_STATUS);
			ps.setString(1, "20%completed");
			ps.setString(2, "no problem");
			ps.setDate(3, new Date(2017, 05, 07));
			ps.setInt(4, 13);
			ps.setInt(5, 1);
			ps.execute();
			System.out.println("last");
		} catch (NoConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}*/
}


