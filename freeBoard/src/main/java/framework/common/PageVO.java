package framework.common;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Alias("pageVO")
public class PageVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4248360501178275807L;

		private int totalCount;
		
		private int rowPerPage = 10;
		
		private int skipCount;
		
		private int page;
}
