/* ==========================================================
 * iSPD : iconic Simulator of Parallel and Distributed System
 * ==========================================================
 *
 * (C) Copyright 2010-2014, by Grupo de pesquisas em Sistemas Paralelos e
 * Distribuídos da Unesp (GSPD).
 *
 * Project Info:  http://gspd.dcce.ibilce.unesp.br/
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 *  USA.
 *
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.]
 *
 * ---------------
 * FiltroDeArquivos.java
 * ---------------
 * (C) Copyright 2014, by Grupo de pesquisas em Sistemas Paralelos e
 * Distribuídos da Unesp (GSPD).
 *
 * Original Author:  Denison Menezes (for GSPD);
 * Contributor(s):   -;
 *
 * Changes
 * -------
 *
 * 09-Set-2014 : Version 2.0;
 *
 */
package ispd.gui.auxiliar;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Implementa FileFilter que permite uma ou mais extensões para um mesmo tipo
 * de arquivo.
 */
public class FiltroDeArquivos extends FileFilter {

    private String description;
    private String[] extensions;
    private final boolean allowDirs;

    public FiltroDeArquivos(final String description, final String[] extensions,
                            final boolean allowDirs) {
        this.description = description;
        this.extensions = extensions;
        this.allowDirs = allowDirs;
    }

    public FiltroDeArquivos(final String description, final String extension,
                            final boolean allowDirs) {
        this.description = description;
        this.extensions = new String[] { extension };
        this.allowDirs = allowDirs;
    }

    public boolean accept(final File file) {
        if (file.isDirectory() && this.allowDirs) {
            return true;
        }
        for (final String ext : this.extensions) {
            if (file.getName().toLowerCase().endsWith(ext)) {
                return true;
            }
        }
        return false;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescricao(final String description) {
        this.description = description;
    }

    public void setExtensao(final String[] extensions) {
        this.extensions = extensions;
    }

    public void setExtensao(final String extension) {
        this.extensions = new String[] { extension };
    }
}