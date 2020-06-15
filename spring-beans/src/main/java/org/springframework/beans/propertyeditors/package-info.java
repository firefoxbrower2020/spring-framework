/**
 * 属性编辑器，用来将string类型的值转换为object类型，例如：java.util.Properties
 * 例如：java.util.Properties。包含的类有：
 * ByteArrayPropertyEditor.java,
 * CharacterEditor.java,
 * CharArrayPropertyEditor.java,
 * CharsetEditor.java,
 * ClassArrayEditor.java,
 * ClassEditor.java,
 * CurrencyEditor.java,
 * CustomBooleanEditor.java,
 * CustomCollectionEditor.java,
 * CustomDateEditor.java,
 * CustomMapEditor.java,
 * CustomNumberEditor.java,
 * FileEditor.java,
 * InputSourceEditor.java,
 * InputStreamEditor.java,
 * LocaleEditor.java,
 * PatternEditor.java,
 * PropertiesEditor.java,
 * ResourceBundleEditor.java,
 * StringArrayPropertyEditor.java,
 * StringTrimmerEditor.java,
 * TimeZoneEditor.java,
 * URIEditor.java,URLEditor.java,
 * UUIDEditor.java,ZoneIdEditor.java
 * 它们的共同特点是实现了PropertyEditorSupport，实现了setAsText，getAsText
 */
@NonNullApi
@NonNullFields
package org.springframework.beans.propertyeditors;

import org.springframework.lang.NonNullApi;
import org.springframework.lang.NonNullFields;
