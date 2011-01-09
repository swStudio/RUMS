<?php

require_once 'lib\UserController.php';

/**
 * UserController test case.
 */
class UserControllerTest extends PHPUnit_Framework_TestCase {
	
	/**
	 * @var UserController
	 */
	private $UserController;
	
	/**
	 * Prepares the environment before running a test.
	 */
	protected function setUp() {
		parent::setUp ();

		$this->UserController = new UserController();
		require_once("lib/SQL.php");
		$con=connect();
		$db=sql_select_db('User_db');
		$this->UserController->_link=$con;		
	}
	
	/**
	 * Cleans up the environment after running a test.
	 */
	protected function tearDown() {	

		$this->UserController = null;
		
		parent::tearDown ();
	}
	
	/**
	 * Constructs the test case.
	 */
	public function __construct() {

	}
	
	/**
	 * Tests UserController->forgetPwEmail()
	 */
	public function testForgetPwEmail() {

		$condition=$this->UserController->forgetPwEmail("2011@163.com");
		$this->assertTrue($condition==true);
	}
	

	
	/**
	 * Tests UserController->modifynicknameByUid()
	 */
	public function testModifynicknameByUid() {
		
		$condition=$this->UserController->modifynicknameByUid(1,"ssw");
		$this->assertTrue($condition==true);
	
	}
	
	/**
	 * Tests UserController->checkPostnickname()
	 */
	public function testCheckPostnickname() {
		
	$this->assertTrue($this->UserController->checkPostnickname("nickname"));
	
	}
	
	/**
	 * Tests UserController->signup()
	 */
	public function testSignupNotSuccess() {

		$condition=$this->UserController->signup("2011@163.com","08386216","111111","","");
		$this->assertTrue($condition!=true);
	}
	public function testSignupSuccess() {

		$condition=$this->UserController->signup("2011@163.com","08386216","111111","","");
		$this->assertTrue($condition==true);
	}
	/**
	 * Tests UserController->isPostInfoSet()
	 */
	public function testIsPostInfoSet() {

		$_POST['ps']=08386216;
		$_POST['pwquestion']="";
		$_POST['pwanswer']="";
		$_POST['name']="";
		$_POST['email']="2011@163.com";
		
		$this->assertTrue($this->UserController->isPostInfoSet());
	
	}
	
	/**
	 * Tests UserController->login()
	 */
	public function testLoginSuccessful() {
		
		$this->assertTrue(($this->UserController->login("2011@163.com","111111")));
	
	}
	public function testLoginNotSuccessful() {
		
		$this->assertTrue(!($this->UserController->login("2011@163.com","111111")));
	
	}
	/**
	 * Tests UserController->setmessage()
	 */
	public function testSetmessage() {

		$this->UserController->setmessage("msg");
		$this->assertTrue($this->UserController->_message=="msg");
	
	}
	
	/**
	 * Tests UserController->setjumpurl()
	 */
	public function testSetjumpurl() {

		$this->UserController->setjumpurl("index.php");
		$this->assertTrue($this->UserController->_url=="index.php");	
	}
	
	/**
	 * Tests UserController->getmessage()
	 */
	public function testGetmessage() {
		
		$this->UserController->setmessage("ok!");
		$this->UserController->setjumpurl("index.php");
		$str=$this->UserController->getmessage();
		$str2="<table width='100%' align=center><tr><td align=center>
              <br>
              <font color=red>ok!</font><br><a href='index.php'>click here</a>
              </td></tr></table>
			  <script language=\"JavaScript\">window.setTimeout(\"window.location.href=\'index.php\'\", 2*1000); </script>";
	
		$this->assertTrue($str==$str2);
	
	}

}

