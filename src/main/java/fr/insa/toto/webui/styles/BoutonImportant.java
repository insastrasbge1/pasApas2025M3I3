/*
Copyright 2000- Francois de Bertrand de Beuvron

This file is part of CoursBeuvron.

CoursBeuvron is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

CoursBeuvron is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with CoursBeuvron.  If not, see <http://www.gnu.org/licenses/>.
 */
package fr.insa.toto.webui.styles;

import com.vaadin.flow.component.button.Button;

/**
 * Essai sur les styles CSS.
 * <p>
 * deux possibilités :
 * <ul>
 *   <li> fixer directement sur un composant avec getStyle + set</li>
 *   <li> utiliser le fichier de style CSS : dans ce cas, le plus simple est
 *        d'associer une classe CSS au composant
 *   </li> 
 * </ul>
 * </p>
 * @author francois
 */
public class BoutonImportant extends Button{
    
    public BoutonImportant(String message) {
        super(message);
        this.setClassName("boutonImportant");
        this.getStyle().set("font-size", "1.5em");
    }
    
}
