package com.firstdevelop.boot.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Product {

	/**
	 * キー
	 */
	private int productId;
	
	/**
	 * 商品名
	 */
	private String productName;
	
	/**
	 * 販売値段
	 */
	private BigDecimal productPrice;
	
	/**
	 * 値段
	 */
	private BigDecimal productAccount;
	
	/**
	 * 生産日時
	 */
	private LocalDateTime productDate;
	
	/**
	 * 産地
	 */
	private String address;
	
	/**
	 * 商品クラスID
	 */
	private int classProductId;
	
	/**
	 * 作成日時
	 */
	private LocalDateTime createTime;
	
	/**
	 * 更新日時
	 */
	private LocalDateTime updateTime;
	
	/**
	 * 作成者
	 */
	private String createUser;
	
	/**
	 * 更新者
	 */
	private String updateUser;
	
	/**
	 * 更新者削除フラグ
	 */
	private String deleteFlag;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public BigDecimal getProductAccount() {
		return productAccount;
	}

	public void setProductAccount(BigDecimal productAccount) {
		this.productAccount = productAccount;
	}

	public LocalDateTime getProductDate() {
		return productDate;
	}

	public void setProductDate(LocalDateTime productDate) {
		this.productDate = productDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getClassProductId() {
		return classProductId;
	}

	public void setClassProductId(int classProductId) {
		this.classProductId = classProductId;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, classProductId, createTime, createUser, deleteFlag, productAccount, productDate,
				productId, productName, productPrice, updateTime, updateUser);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(address, other.address) && classProductId == other.classProductId
				&& Objects.equals(createTime, other.createTime) && Objects.equals(createUser, other.createUser)
				&& Objects.equals(deleteFlag, other.deleteFlag) && Objects.equals(productAccount, other.productAccount)
				&& Objects.equals(productDate, other.productDate) && productId == other.productId
				&& Objects.equals(productName, other.productName) && Objects.equals(productPrice, other.productPrice)
				&& Objects.equals(updateTime, other.updateTime) && Objects.equals(updateUser, other.updateUser);
	}
	
}
