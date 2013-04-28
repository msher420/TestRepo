package com.balusc;

public class PagCheck {

	/**
	 * @param args
	 */

	// Paging.
	private static int firstRow;
	private static int rowsPerPage;
	private static int totalPages;
	private static int pageRange;
	private static Integer[] pages;
	private static int currentPage;

	public static void main(String[] args) {
		rowsPerPage = 10; // Default rows per page (max amount of rows to be
							// displayed at once).
		pageRange = 10; // Default page range (max amount of page links to be
						// displayed at once).
		int totalRows = 200;
		
		firstRow = 1;
		int lastRow =firstRow-1;
		currentPage = (totalRows / rowsPerPage)
				- ((totalRows - lastRow) / rowsPerPage) + 1;
		totalPages = (totalRows / rowsPerPage)
				+ ((totalRows % rowsPerPage != 0) ? 1 : 0);
		int pagesLength = Math.min(pageRange, totalPages);
		pages = new Integer[pagesLength];

		// firstPage must be greater than 0 and lesser than
		// totalPages-pageLength.
		int firstPage = Math.min(Math.max(0, currentPage - (pageRange / 2)),
				totalPages - pagesLength);

		// Create pages (page numbers for page links).
		for (int i = 0; i < pagesLength; i++) {
			pages[i] = ++firstPage;
			System.out.println(pages[i]);
		}
		
		System.out.println("firstRow -> " + firstRow);
		System.out.println("rowsPerPage -> " + rowsPerPage);
		System.out.println("totalPages -> " + totalPages);
		System.out.println("pageRange -> " + pageRange);
		System.out.println("pages -> " + pages);
		System.out.println("currentPage -> " + currentPage);
		System.out.println(" pagesLength -> "+ pagesLength);
//		System.out.println(" -> ");
		

	}

}
