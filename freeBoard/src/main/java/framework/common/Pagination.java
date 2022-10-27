package framework.common;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Alias("pageVO")
public class Pagination {

	private static final int ROW_PER_PAGE = 10;
	private static final int PAGE_PER_BLOCK = 10;
	
	//페이지당 글 
	private int rowPerPage = ROW_PER_PAGE;
	//블럭(페이징)당 페이지 
	private int pagePerBlock = PAGE_PER_BLOCK;
	//총 글 수
	private int totalRow = 0;
	//현 페이지
	private int currentPage = 1;
	
	public Pagination() {
	}
	
	public Pagination setTotalRow(int totalRow) {
		this.totalRow = totalRow;
		return this;
	}
	
	public Pagination setTotalRow(String totalRow) {
		return setTotalRow(NumberUtils.toInt(totalRow,0));
	}
	
	public Pagination setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		return this;
	}
	
	public Pagination setCurrentPage(String currentPage) {
		return setCurrentPage(NumberUtils.toInt(currentPage,1));
	}
	
	public Pagination setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
		return this;
	}
	
	public Pagination setRowPerPage(String rowPerPage) {
		return setRowPerPage(NumberUtils.toInt(rowPerPage, ROW_PER_PAGE));
	}
	
	public Pagination setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
		return this;
	}
	
	public Pagination setPagePerBlock(String pagePerBlock) {
		return setPagePerBlock(NumberUtils.toInt(pagePerBlock, PAGE_PER_BLOCK));
	}
	
	public int getTotalRow() {
		return totalRow;
	}
	
	public int getCurrentPage() {
		int totalPage = getTotalPage();
		return currentPage <= 0? 1:(totalPage > 0 && totalPage < currentPage ? totalPage : currentPage);
	}
	
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	
	public int getTotalPage() {
		return (int)Math.ceil((totalRow * 1.0) / (rowPerPage * 1.0));
	}
	
	public int getFirstPage() {
		return (int) ((currentPage - 1) / pagePerBlock) * pagePerBlock + 1;
	}
	
	public int getLastPage() {
		int end = getTotalPage() - getFirstPage()+ 1;
		return (end < pagePerBlock) ? getTotalPage() : pagePerBlock + getFirstPage() - 1;
	}
	
	public int getSkipCount() {
		int skipCount = rowPerPage * (getCurrentPage() - 1);
		skipCount = skipCount < 0 ? 0 : skipCount;
		return skipCount;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
	
	@JsonIgnore
	public String getPostLimit() {
		return "LIMIT" + this.getRowPerPage() + "OFFSET" + this.getSkipCount() + " ";
	}
}
