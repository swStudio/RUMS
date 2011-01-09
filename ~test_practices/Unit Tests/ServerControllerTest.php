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
		
		$this->ServerController = new ServerController(1);
		require_once("lib/SQL.php");
		$con=connect();
		$db=sql_select_db("User_db");
		$this->ServerController->_link=$con;
	}
	
	/**
	 * Cleans up the environment after running a test.
	 */
	protected function tearDown() {

		$this->ServerController = null;
		
		parent::tearDown ();
	}
	
	/**
	 * Constructs the test case.
	 */
	public function __construct() {
	
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
		
		$this->assertTrue($this->ServerController->getUid()==1);
	}
	public function testChangeServerController() {
		
		$this->ServerController->ServerController(2);
		$this->assertTrue($this->ServerController->getUid()==2);
	}
	/**
	 * Tests ServerController->isPost()
	 */
	public function testIsPost() {
		
		$_POST['userId']=1;
		$this->assertTrue($this->ServerController->isPost('userId'));
	}
	public function testIsPost2() {

		$this->assertTrue(!$this->ServerController->isPost('Server'));
	}
	/**
	 * Tests ServerController->addNewServer()
	 */
	public function testAddNewServerSuccessful() {

		$this->ServerController->addNewServer("friendsPanel");
		$condition=$this->ServerController->_message=="A new Server is created!";
		$this->assertTrue($condition);
	}
	public function testAddNewServerNotSuccessful() {

		$this->ServerController->addNewServer("");
		$condition=$this->ServerController->_message=="Failed to create a new Server";
		$this->assertTrue($condition);
	}
	/**
	 * Tests ServerController->getnewServerHTML()
	 */
	public function testGetnewServerHTML() {
		
		$str=$this->ServerController->getnewServerHTML();
		$condition=$str!="";
		$this->assertTrue($condition);
	}
	
	/**
	 * Tests ServerController->getMessage()
	 */
	public function testGetMessage() {

		$this->ServerController->setMessage("ok!");
		$this->ServerController->setUrl("index.php");
		$this->ServerController->getMessage();
		$str="<head>
						<title>Server</title>
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

