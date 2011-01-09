<?php

require_once 'lib\ServerController.php';

require_once 'PHPUnit\Framework\TestCase.php';

/**
 * ServerController test case.
 */
class ServerControllerTest extends PHPUnit_Framework_TestCase {
	
	/**
	 * @var ServerController
	 */
	private $ServerController;
	
	/**
	 * Prepares the environment before running a test.
	 */
	protected function setUp() {
		parent::setUp ();
		
		// TODO Auto-generated ServerControllerTest::setUp()
		$this->ServerController = new ServerController(1);
		require_once("lib/MySQL.php");
		$con=connect();
		$db=mysql_select_db("user_db");
		$this->ServerController->_link=$con;
	}
	
	/**
	 * Cleans up the environment after running a test.
	 */
	protected function tearDown() {
		// TODO Auto-generated ServerControllerTest::tearDown()
		

		$this->ServerController = null;
		
		parent::tearDown ();
	}
	
	/**
	 * Constructs the test case.
	 */
	public function __construct() {
		// TODO Auto-generated constructor
	}
	
	/**
	 * Tests ServerController->isEmpty($para)
	 */
	public function testisEmpty(){
		$condition=$this->ServerController->isEmpty("abc");
		$this->assertTrue($condition==false);
	}
	
	public function testEmpty(){
	
		$this->assertTrue($this->ServerController->isEmpty(""));
	}
	/**
	 * Tests ServerController->ServerController()
	 */
	public function testServerController() {
		// TODO Auto-generated ServerControllerTest->testServerController()
		//$this->markTestIncomplete ( "ServerController test not implemented" );
		//$this->ServerController->ServerController(1);
		$this->assertTrue($this->ServerController->getUid()==1);
	}
	public function testChangeServerController() {
		// TODO Auto-generated ServerControllerTest->testServerController()
		//$this->markTestIncomplete ( "ServerController test not implemented" );
		//$this->ServerController->ServerController(1);
		$this->ServerController->ServerController(2);
		$this->assertTrue($this->ServerController->getUid()==2);
	}
	/**
	 * Tests ServerController->isPost()
	 */
	public function testIsPost() {
		// TODO Auto-generated ServerControllerTest->testIsPost()
		//$this->markTestIncomplete ( "isPost test not implemented" );
		$_POST['uid']=1;
		$this->assertTrue($this->ServerController->isPost('uid'));
	}
	public function testIsPost2() {
		// TODO Auto-generated ServerControllerTest->testIsPost()
		//$this->markTestIncomplete ( "isPost test not implemented" );
		$this->assertTrue(!$this->ServerController->isPost('Server'));
	}
	/**
	 * Tests ServerController->addNewServer()
	 */
	public function testAddNewServerSuccessful() {
		// TODO Auto-generated ServerControllerTest->testAddNewServer()
		//$this->markTestIncomplete ( "addNewServer test not implemented" );
		$this->ServerController->addNewServer("sunday");
		$condition=$this->ServerController->_message=="A new Server is created!";
		$this->assertTrue($condition);
	}
	public function testAddNewServerNotSuccessful() {
		// TODO Auto-generated ServerControllerTest->testAddNewServer()
		//$this->markTestIncomplete ( "addNewServer test not implemented" );
		$this->ServerController->addNewServer("");
		$condition=$this->ServerController->_message=="Failed to create a new Server";
		$this->assertTrue($condition);
	}
	/**
	 * Tests ServerController->getnewServerHTML()
	 */
	public function testGetnewServerHTML() {
		// TODO Auto-generated ServerControllerTest->testGetnewServerHTML()
		//$this->markTestIncomplete ( "getnewServerHTML test not implemented" );
		
		$str=$this->ServerController->getnewServerHTML();
		$condition=$str!="";
		$this->assertTrue($condition);
	}
	
	/**
	 * Tests ServerController->getMessage()
	 */
	public function testGetMessage() {
		// TODO Auto-generated ServerControllerTest->testGetMessage()
		//$this->markTestIncomplete ( "getMessage test not implemented" );
		$this->ServerController->setMessage("ok!");
		$this->ServerController->setUrl("index.php");
		$this->ServerController->getMessage();
		$str="<head>
						<title>My Pictrue</title>
						<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />
						<link rel=\"stylesheet\" type=\"text/css\" href=\"css/forget.css\" />
						<script type\"text/javascript\">
						window.setTimeout(\"window.location.href='index.php'\",4*1000);
						</script>
				</head>
					<body>
					<table width='100%' align=center><tr><td align=center>
					  ok!<br>
					 <input type=\"button\" value=\"<<back\" name=\"back\" onClick=\"window.location.href='index.php'\">
					 </td></tr></table>
					 </body>";
	}

}

