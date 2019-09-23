/*
 * No license is included with the package at this time.
 * Copyright 2018, Finck (github.com/cfinck27) and Gryphon (github.com/GriffFr)
 */

package projectjellyfish.window.input;

public enum KeyEnum
{
    KEY_UNKNOWN(0, '\0', "unknown"),
    KEY_ENTER(10, '\n', "enter"),
    KEY_BACKSPACE(8, '\b', "backspace"),
    KEY_TAB(9, '\t', "tab"),
    KEY_CANCEL(3, '?', "cancel"),
    KEY_CLEAR(12, '?', "clear"),
    KEY_SHIFT(16, '?', "shift"),
    KEY_CONTROL(17, '?', "control"),
    KEY_ALT(18, '?', "alt"),
    KEY_PAUSE(19, '?', "pause"),
    KEY_CAPS_LOCK(20, '?', "caps lock"),
    KEY_ESCAPE(27, '?', "escape"),
    KEY_SPACE(32, ' ', "space"),
    KEY_PAGE_UP(33, '?', "page up"),
    KEY_PAGE_DOWN(34, '?', "page down"),
    KEY_END(35, '?', "end"),
    KEY_HOME(36, '?', "home"),
    KEY_LEFT(37, '?', "left"),
    KEY_UP(38, '?', "up"),
    KEY_RIGHT(39, '?', "right"),
    KEY_DOWN(40, '?', "down"),
    KEY_COMMA(44, ',', "comma"),
    KEY_MINUS(45, '-', "minus"),
    KEY_PERIOD(46, '.', "period"),
    KEY_SLASH(47, '/', "slash"),
    KEY_ZERO(48, '0', "zero"),
    KEY_ONE(49, '1', "one"),
    KEY_TWO(50, '2', "two"),
    KEY_THREE(51, '3', "three"),
    KEY_FOUR(52, '4', "four"),
    KEY_FIVE(53, '5', "five"),
    KEY_SIX(54, '6', "six"),
    KEY_SEVEN(55, '7', "seven"),
    KEY_EIGHT(56, '8', "eight"),
    KEY_NINE(57, '9', "nine"),
    KEY_SEMICOLON(59, ';', "semicolon"),
    KEY_EQUALS(61, '=', "equals"),
    KEY_A(65, 'a', "a"),
    KEY_B(66, 'b', "b"),
    KEY_C(67, 'c', "c"),
    KEY_D(68, 'd', "d"),
    KEY_E(69, 'e', "e"),
    KEY_F(70, 'f', "f"),
    KEY_G(71, 'g', "g"),
    KEY_H(72, 'h', "h"),
    KEY_I(73, 'i', "i"),
    KEY_J(74, 'j', "j"),
    KEY_K(75, 'k', "k"),
    KEY_L(76, 'l', "l"),
    KEY_M(77, 'm', "m"),
    KEY_N(78, 'n', "n"),
    KEY_O(79, 'o', "o"),
    KEY_P(80, 'p', "p"),
    KEY_Q(81, 'q', "q"),
    KEY_R(82, 'r', "r"),
    KEY_S(83, 's', "s"),
    KEY_T(84, 't', "t"),
    KEY_U(85, 'u', "u"),
    KEY_V(86, 'v', "v"),
    KEY_W(87, 'w', "w"),
    KEY_X(88, 'x', "x"),
    KEY_Y(89, 'y', "y"),
    KEY_Z(90, 'z', "z"),
    KEY_OPEN_BRACKET(91, '{', "open bracket"),
    KEY_BACK_SLASH(92, '\\', "backslash"),
    KEY_CLOSE_BRACKET(93, '}', "close bracket"),
    KEY_NUMPAD_ZERO(96, '0', "numpad zero"),
    KEY_NUMPAD_ONE(97, '1', "numpad one"),
    KEY_NUMPAD_TWO(98, '2', "numpad two"),
    KEY_NUMPAD_THREE(99, '3', "numpad three"),
    KEY_NUMPAD_FOUR(100, '4', "numpad four"),
    KEY_NUMPAD_FIVE(101, '5', "numpad five"),
    KEY_NUMPAD_SIX(102, '6', "numpad six"),
    KEY_NUMPAD_SEVEN(103, '7', "numpad seven"),
    KEY_NUMPAD_EIGHT(104, '8', "numpad eight"),
    KEY_NUMPAD_NINE(105, '9', "numpad nine"),
    KEY_MULTIPLY(106, '*', "multiply"),
    KEY_ADD(107, '+', "add"),
    KEY_SEPARATER(108, '?', "separater"),
    KEY_SUBTRACT(109, '-', "subtract"),
    KEY_DECIMAL(110, '.', "decimal"),
    KEY_DIVIDE(111, '/', "divide"),
    KEY_DELETE(127, '?', "delete"),
    KEY_NUM_LOCK(144, '?', "num lock"),
    KEY_SCROLL_LOCK(145, '?', "scroll lock"),
    KEY_F1(112, '?', "f1"),
    KEY_F2(113, '?', "f2"),
    KEY_F3(114, '?', "f3"),
    KEY_F4(115, '?', "f4"),
    KEY_F5(116, '?', "f5"),
    KEY_F6(117, '?', "f6"),
    KEY_F7(118, '?', "f7"),
    KEY_F8(119, '?', "f8"),
    KEY_F9(120, '?', "f9"),
    KEY_F10(121, '?', "f10"),
    KEY_F11(122, '?', "f11"),
    KEY_F12(123, '?', "f12"),
    KEY_F13(61440, '?', "f13"),
    KEY_F14(61441, '?', "f14"),
    KEY_F15(61442, '?', "f15"),
    KEY_F16(61443, '?', "f16"),
    KEY_F17(61444, '?', "f17"),
    KEY_F18(61445, '?', "f18"),
    KEY_F19(61446, '?', "f19"),
    KEY_F20(61447, '?', "f20"),
    KEY_F21(61448, '?', "f21"),
    KEY_F22(61449, '?', "f22"),
    KEY_F23(61450, '?', "f23"),
    KEY_F24(61451, '?', "f24"),
    KEY_PRINT_SCREEN(154, '?', "print screen"),
    KEY_INSERT(155, '?', "insert"),
    KEY_HELP(156, '?', "help"),
    KEY_META(157, '?', "meta"),
    KEY_BACK_QUOTE(192, '`', "back quote"),
    KEY_QUOTE(222, '\'', "quote"),
    KEY_NUMPAD_UP(224, '?', "numpad up"),
    KEY_NUMPAD_DOWN(225, '?', "numpad down"),
    KEY_NUMPAD_LEFT(226, '?', "numpad left"),
    KEY_NUMPAD_RIGHT(227, '?', "numpad right"),
    KEY_AMPERSAND(150, '&', "ampersand"),
    KEY_ASTERISK(151, '*', "asterisk"),
    KEY_DOUBLE_QUOTE(152, '"', "double quote"),
    KEY_LESS(153, '<', "less"),
    KEY_GREATER(160, '>', "greater"),
    KEY_BRACE_LEFT(161, '[', "brace left"),
    KEY_BRACE_RIGHT(162, ']', "brace right"),
    KEY_AT(512, '@', "at"),
    KEY_COLON(513, ':', "colon"),
    KEY_CIRCUMFLEX(514, '?', "circumflex"),
    KEY_DOLLAR(515, '$', "dollar"),
    KEY_EURO(516, '?', "euro"),
    KEY_EXCLAMATION_MARK(517, '!', "exclamation mark"),
    KEY_EXCLAMATION_MARK_INVERTED(518, '?', "inverted exclamation mark"),
    KEY_PARENTHESIS_LEFT(519, '(', "parenthesis left"),
    KEY_NUMBER_SIGN(520, '#', "number sign"),
    KEY_PLUS(521, '+', "plus"),
    KEY_PARENTHESIS_RIGHT(522, ')', "parenthesis right"),
    KEY_UNDERSCORE(523, '_', "underscore"),
    KEY_WINDOWS(524, '?', "windows"),
    KEY_CONTEXT_MENU(525, '?', "context menu"),
    KEY_CUT(65389, '?', "cut"),
    KEY_COPY(65385, '?', "copy"),
    KEY_PASTE(65487, '?', "paste"),
    KEY_UNDO(65483, '?', "undo"),
    KEY_AGAIN(65481, '?', "again"),
    KEY_FIND(65488, '?', "find"),
    KEY_PROPS(65482, '?', "props"),
    KEY_STOP(65480, '?', "stop"),
    KEY_COMPOSE(65312, '?', "compose"),
    KEY_ALT_GRAPH(65406, '?', "alt graph"),
    KEY_BEGIN(65368, '?', "begin"),
    ;
    
        
    public final int keyCode;
    public final char keyChar;
    public final String keyName;
    
    KeyEnum(int keyCode, char keyChar, String keyName)
    {
        this.keyCode = keyCode;
        this.keyChar = keyChar;
        this.keyName = keyName;
    }
    
    @Override
    public String toString()
    {
        return keyName;
    }
    
    public static KeyEnum getKeyByCode(int code)
    {
        for (KeyEnum key : KeyEnum.values())
        {
            if (key.keyCode == code)
            {
                return key;
            }
        }
        return null;
    }
    
    public static KeyEnum getKeyByChar(char c)
    {
        for (KeyEnum key : KeyEnum.values())
        {
            if (key.keyChar == c)
            {
                return key;
            }
        }
        return null;
    }
    
}