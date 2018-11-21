package org.leo.ram.domain;

/**
 * 账户管理系统的账户实体类(简化版)
 * @author leoliu
 * CREATE TABLE `ram_account` (
  `acct_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '账户编号(主键)',
  `acct_name` varchar(32) NOT NULL COMMENT '持有者名称',
  `acct_location` varchar(32) DEFAULT NULL COMMENT '账户注册地',
  `acct_type` varchar(32) DEFAULT NULL COMMENT '账户类型',
  `acct_level` varchar(32) DEFAULT NULL COMMENT '账户级别',
  `acct_phone` varchar(16) DEFAULT NULL COMMENT '联系电话',
  `acct_serial` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`acct_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 */
public class Account {
	
	private Long acct_id;
	private String acct_name;
	private String acct_location;
	private String acct_type;
	private String acct_level;
	private String acct_phone;
	private String acct_serial;
	public Long getAcct_id() {
		return acct_id;
	}
	public void setAcct_id(Long acct_id) {
		this.acct_id = acct_id;
	}
	public String getAcct_name() {
		return acct_name;
	}
	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}
	public String getAcct_location() {
		return acct_location;
	}
	public void setAcct_location(String acct_location) {
		this.acct_location = acct_location;
	}
	public String getAcct_type() {
		return acct_type;
	}
	public void setAcct_type(String acct_type) {
		this.acct_type = acct_type;
	}
	public String getAcct_level() {
		return acct_level;
	}
	public void setAcct_level(String acct_level) {
		this.acct_level = acct_level;
	}
	public String getAcct_phone() {
		return acct_phone;
	}
	public void setAcct_phone(String acct_phone) {
		this.acct_phone = acct_phone;
	}
	public String getAcct_serial() {
		return acct_serial;
	}
	public void setAcct_serial(String acct_serial) {
		this.acct_serial = acct_serial;
	}
	
}
