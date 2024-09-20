package com.cream.team01.vo;

public class CategoryVO {
	
	public int categoryNo;
	public String categoryName;
	public String categoryEnglishName;
	
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getCategoryEnglishName() {
        switch (this.categoryNo) {
            case 1: return "Top";
            case 2: return "Bottom";
            case 3: return "Outer";
            case 4: return "Shoes";
            default: return "Unknown";
        }
    }

    public void setCategoryEnglishName(String categoryEnglishName) {
        this.categoryEnglishName = categoryEnglishName;
    }
	
	@Override
	public String toString() {
		return "CategoryVO [categoryNo=" + categoryNo + ", categoryName=" + categoryName + "]";
	}
	
	
	
	
	
	
	

}
