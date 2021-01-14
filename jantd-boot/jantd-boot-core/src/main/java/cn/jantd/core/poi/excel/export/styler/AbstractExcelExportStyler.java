/**
 *
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.jantd.core.poi.excel.export.styler;

import cn.jantd.core.poi.excel.entity.params.ExcelExportEntity;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * 抽象接口提供两个公共方法
 *
 * @author  圈哥
 * @date 2015年1月9日 下午5:48:55
 */
public abstract class AbstractExcelExportStyler implements IExcelExportStyler {


	protected CellStyle stringNoneStyle;
	protected CellStyle stringNoneWrapStyle;
	protected CellStyle stringSeptailStyle;
	protected CellStyle stringSeptailWrapStyle;

	protected Workbook workbook;

	protected static final short STRING_FORMAT = (short) BuiltinFormats.getBuiltinFormat("TEXT");

	protected void createStyles(Workbook workbook) {
		this.stringNoneStyle = stringNoneStyle(workbook, false);
		this.stringNoneWrapStyle = stringNoneStyle(workbook, true);
		this.stringSeptailStyle = stringSeptailStyle(workbook, false);
		this.stringSeptailWrapStyle = stringSeptailStyle(workbook, true);
		this.workbook = workbook;
	}

	@Override
	public CellStyle getStyles(boolean noneStyler, ExcelExportEntity entity) {
		if (noneStyler && (entity == null || entity.isWrap())) {
			return stringNoneWrapStyle;
		}
		if (noneStyler) {
			return stringNoneStyle;
		}
		if (noneStyler == false && (entity == null || entity.isWrap())) {
			return stringSeptailWrapStyle;
		}
		return stringSeptailStyle;
	}

	public CellStyle stringNoneStyle(Workbook workbook, boolean isWarp) {
		return null;
	}

	public CellStyle stringSeptailStyle(Workbook workbook, boolean isWarp) {
		return null;
	}

}